<?php
session_start();

function highlight($text, $search) {
    return $search ? str_ireplace($search, '<mark>' . $search . '</mark>', htmlspecialchars($text)) : htmlspecialchars($text);
}
$dsn = 'mysql:host=localhost;dbname=testresults';
$user = 'root';
$pass = '';
$conn = new PDO($dsn, $user, $pass);

$result = [];
$searchMessage = '';
$search = (isset($_POST['search']) ? trim($_POST['search']) : ''  );

    if (!empty($search)) {
        $sql = "SELECT * FROM results  WHERE test_name LIKE :search OR status LIKE :search OR created_at LIKE :search " ;
        $stmt = $conn->prepare($sql);
        $stmt->bindValue(':search', '%' . $search . '%');
        $stmt->execute();
        $result = $stmt->fetchAll();
        if (empty($result)) {
            $searchMessage = 'No results found for "' . htmlspecialchars($search) . '"';
        }
    }
   if(empty($search) or !isset($_POST['search'])){
    $query = $conn->query("SELECT * FROM results");
    $result = $query->fetchAll();
  }

if(isset($_POST['ajax']) && $_POST['ajax'] === '1'){
    if (isset($_SESSION["pass_session"]) && isset($_SESSION["name_session"])) {
            if (!empty($searchMessage)) {
                echo "<tr><td colspan='8'>$searchMessage</td></tr>";
            } else {
                foreach ($result as $key) {
                    echo "<tr>";

               echo "<td>" . highlight($key['test_name'], $search) . "</td>";
               echo "<td>" . highlight($key['status'], $search) . "  </td>";
               echo "<td>" . highlight($key['created_at'], $search) . "</td>";

               echo "<td>
               <a href='javascript:void(0);' data-id='" . htmlspecialchars($key['id']) . "' class='button delete'>Delete</a>
           </td>";
               echo "</tr>";
                }
            }
        } else {
            echo '<tr><td colspan="8">You are not admin , Please login with <span class="MesssageLogin">(---> Eng.Mostafa OR admin)</span> <button><a href="login.php" target="_blank">Login</a></button></td></tr>';
        }
        exit;
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>View testcase</title>

</head>
<body>
    <div class="typing-container">
        <h1 id="typing"></h1>
    </div>
    <?php
if (isset(  $_SESSION["name_session"] )) {
    echo " <a href='login.php'><button  class='btn'>logout</button></a>";
} else {
    echo " <a href='login.php'><button class='btn' >login</button></a>";
}
if (isset($_SESSION["name_session"] )) {
    printf('<h3 >Hello, %s</h3>', $_COOKIE["name_cookie"]);
}
?>
    <form id="searchForm" action="" method="post">
        <input type="text" placeholder="Search..." name="search" id='searchinput'>
        <input type="submit" value="Search">
    </form>

       <!-- export -->
    <form action="export.php" method="post" style="text-align: center; margin-top: 10px;">
        <?php
    if (isset(  $_SESSION["name_session"] )) {
    echo '<input type="submit" value=" EXPORT DATA 📤  ">';
} ?>

</form>

    <table>
        <tr>
            <th>Test Name</th>
            <th>Status</th>
            <th>Date</th>
            <th>Control</th>
        </tr>
        <tbody id='tableBody'>
        <?php
        if (isset($_SESSION["pass_session"]) && isset($_SESSION["name_session"])) {
            if (!empty($searchMessage)) {
                echo "<tr><td colspan='8'>$searchMessage</td></tr>";
            } else {
                foreach ($result as $key) {
                    echo "<tr>";
               echo "<td>" . highlight($key['test_name'], $search) . "</td>";
               echo "<td>" . highlight($key['status'], $search) . " </td>";
               echo "<td>" . highlight($key['created_at'], $search) . "</td>";
               echo "<td>
               <a href='javascript:void(0);' id='" . htmlspecialchars($key['id']) . "' class='button delete'>Delete</a>
           </td>";
           
                }
            }
        } else {
            echo '<tr><td colspan="8">You are not admin #Mostafa <button><a href="login.php" target="_blank">Login</a></button></td></tr>';
        }
        ?>
        </tbody>
    </table>
        <script src="main.js"></script>
</body>
</html>

