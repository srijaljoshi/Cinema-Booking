

document.getElementById("myInput").onkeyup = function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0]; // 0 is for the first column
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