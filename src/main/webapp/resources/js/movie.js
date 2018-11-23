
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
 * AJAX request for deleting movie
 */

$(".btn-delete-movie").click(function (e) {
    e.preventDefault();
    var id = document.getElementById("movieID").innerText;
    var tr = $(this).closest('tr');
    var del_id = tr.attr('id');
    $.ajax({
        url: "/a/movies/" + del_id,
        method: "DELETE",
        success: function (data) {
            alert("Deleted a movie with id = " + del_id);
            tr.remove();
        }
    });

});
// document.getElementById("btn-delete-movie").onclick = function deleteMovie(event) {
//     var xhr = new XMLHttpRequest();
//     var id = document.getElementById("movieID").innerText;
//     console.log(">>> Deleting movie with id: " + id);
//
//     var tr = document.getElementById("myTable").getElementsByTagName("tr");
//
//     xhr.onreadystatechange = function() {
//         if (this.readyState == 4 && this.status == 200) {
//
//             // here you need to write what to do after the request is completed
//             // https://www.w3schools.com/xml/ajax_xmlhttprequest_create.asp
//             tr[parseInt(id) - 1].style.display = "none";
//             // document.getElementById("movie" + id).style.display = none;
//         }
//     };
//     xhr.open("DELETE", "/a/movies/" + id, true);
//     console.log(">>> Inside deleteMovie AJAX request opened!!!")
//     xhr.send();
// }





// $('#newMovieForm').submit(function (e) {
//     e.preventDefault();
//     console.log($( this ).serialize());
//     // $.ajax(
//     //     method: 'GET',
//     //
//     // );
//     $.post("/a/movies/new", $('newMovieForm').serialize(), function(data, status){
//         // console.log("\nStatus: " + status);
//     });
//
// });