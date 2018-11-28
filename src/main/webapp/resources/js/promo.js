
if(document.getElementById("myInput") != null) {
    document.getElementById("myInput").onkeyup = function () {
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

}
/**
 * AJAX request for deleting movie
 */

$(".btn-delete-promo").click(function (e) {
    e.preventDefault();
    // var id = document.getElementById("movieID").innerText;
    var tr = $(this).closest('tr');
    var del_id = tr.attr('zid');
    if(confirm("Are you sure?")) {
        $.ajax({
            url: "/a/promos/" + del_id,
            method: "DELETE",
            success: function (data) {
                alert("Deleted a promo with id = " + del_id);
                tr.remove();
                console.log(data);
            }
        });
    }
    else {
        console.log("Not deleted!");
    }

});
