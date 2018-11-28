
document.getElementById("myInput").onkeyup = function() {
    // Declare variables
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = ""; //reset display css property if filtered and is in the view
                console.log("Filtered " + i);
            } else {
                // If not what the user wanted then set display property to none to make it invisible
                tr[i].style.display = "none";
            }
        }
    }
}


/**
 * AJAX request for deleting hall
 */

$(".btn-delete-hall").click(function (e) {
    e.preventDefault();
    // var id = document.getElementById("hallID").innerText;
    var tr = $(this).closest('tr');
    var del_id = tr.attr('zid');
    // fake delete here!!!
    $.ajax({
        url: "/a/halls", // change to /a/hall/ + del_id
        method: "GET", // change to delete
        success: function (data) {
            alert("Deleted a hall with id = " + del_id);
            tr.remove();
        }
    }).done(function () {
        tr.remove();
    });

});