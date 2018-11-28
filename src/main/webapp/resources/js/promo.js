
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

$(".btn-delete-movie").click(function (e) {
    e.preventDefault();
    var id = document.getElementById("movieID").innerText;
    var tr = $(this).closest('tr');
    var del_id = tr.attr('zid');
    $.ajax({
        url: "/a/movies/" + del_id,
        method: "DELETE",
        success: function (data) {
            alert("Deleted a movie with id = " + del_id);
            tr.remove();
        }
    });

});

/**
 * Get search results using ajax resquest
 */

var searchResults = $("#searchResults");

$("#btn-search-movie").click(function (e) {
    e.preventDefault();
    //
    // var urlParams = new URLSearchParams(window.location.search);
    // alert("Url Params: " + urlParams)
    var movieTitle = document.getElementById("movieTitle").value;
    searchResults.empty(); // clear the div before displaying items for a new request
    $.ajax({
        url: "/u/search_results/",
        method: "GET",
        data: {
            "title": movieTitle
        },
        contentType: "application/json",
        success: function (movies) {
            console.log(movies);
            // $("#searchResults").append(JSON.stringify(movies));
            // alert("Found a movie with title = " + data.title);
            for(i=0; i<movies.length; i++) {
                displayMovie(movies[i]);
            }
        }
    });

});

var displayMovie = function(movie) {

    var htmlstring = "";

    var trailerPicture = movie.trailerPicture;
    htmlstring += "" +
        "<div class='col-md-4'>" +
        "<img class='img-thumbnail'  style='height: 300px; weight: 200px;' src=" + trailerPicture + "> " +
        "<p> Title: " + movie.title + "</p>" +
        "<p>Director: " + movie.director + "</p>" +
        "</div>";

    // htmlstring.append("Tello");

    searchResults.append(htmlstring);
    // $('#searchResults').append('<img class="img-thumbnail" src="' + movie.trailerPicture + '">');
    // $('#searchResults').append('<p> Title: ' + movie.title + '</p>');
    // $('#searchResults').append('<p>Director: ' + movie.director+ '</p>');
}

$("#btn-clear-movie").click(function (e) {
    e.preventDefault();
    $("#searchResults").empty();
});


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