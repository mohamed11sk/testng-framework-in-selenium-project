<?php
require 'vendor/autoload.php';

use PhpOffice\PhpSpreadsheet\Spreadsheet;
use PhpOffice\PhpSpreadsheet\Writer\Xlsx;

$dsn = 'mysql:host=localhost;dbname=testresults';
$user = 'root';
$pass = '';
$conn = new PDO($dsn, $user, $pass);

$query = $conn->query("SELECT * FROM results");
$results = $query->fetchAll();

$spreadsheet = new Spreadsheet();
$sheet = $spreadsheet->getActiveSheet();

$sheet->setCellValue('A1', 'Test Name');
$sheet->setCellValue('B1', 'Status');
$sheet->setCellValue('C1', 'Created At');

$rowNumber = 2;
foreach ($results as $row) {
    $sheet->setCellValue('A' . $rowNumber, $row['test_name']);
    $sheet->setCellValue('B' . $rowNumber, $row['status']);
    $sheet->setCellValue('C' . $rowNumber, $row['created_at']);
    $rowNumber++;
}

$filename = 'Automation_test_case.xlsx';
header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
header("Content-Disposition: attachment; filename=\"$filename\"");
header('Cache-Control: max-age=0');

$writer = new Xlsx($spreadsheet);
$writer->save('php://output');
exit;
?>
