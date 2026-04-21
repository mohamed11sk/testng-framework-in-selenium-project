function fetchData() {
  //---->ajax
  $.ajax({
    url: "",
    method: "POST",
    data: {
      ajax: "1",
      search: $("#searchinput").val(),
    },
    success: function (data) {
      $("#tableBody").html(data);
    },
  });
}
fetchData();
setInterval(fetchData, 500);
$(document).ready(function () {
  //---***-> animation
  $("table").hide().fadeIn(1000);
  $("tr").each(function (i) {
    $(this)
      .delay(i * 100)
      .fadeIn(300);
  });
});

const text = "Automation Test Case"; //--*********--->Behavior write
let index = 0;
function typeWriter() {
  if (index < text.length) {
    document.getElementById("typing").textContent += text.charAt(index);
    index++;
    setTimeout(typeWriter, 200);
  } else {
    setTimeout(() => {
      document.getElementById("typing").textContent = "";
      index = 0;
      typeWriter();
    }, 200);
  }
}
typeWriter();

function confirmDelete(id) {
  ///---******-> Delete record
  Swal.fire({
    title: "Confirm Delete",
    text: "Are you sure you want to delete this message?",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#ff00aa",
    cancelButtonColor: "#00c3ff",
    confirmButtonText: "Delete",
    cancelButtonText: "Cancel",
    background: "#1a1a2e",
    color: "#fff",
  }).then((result) => {
    if (result.isConfirmed) {
      window.location.href = "delete_message.php?id=" + id;
    }
  });
}
$(document).on("click", ".delete", function () {
  var id = $(this).data("id");
  confirmDelete(id);
});
