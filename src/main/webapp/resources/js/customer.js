// document.getElementById("btn-suspend").onclick = function (ev) {
//     // var xhr = new XMLHttpRequest();
//     // var id = document.getElementById("userID").innerText;
//     console.log(">>> Suspending user with id: " + 223);
//     //
//     // var suspend = document.getElementById("btn-suspend");
//     // // var reactivate = document.getElementById("btn-reactivate");
//     //
//     // xhr.onreadystatechange = function() {
//     //     if (this.readyState == 4 && this.status == 200) {
//     //
//     //         // here you need to write what to do after the request is completed
//     //         // https://www.w3schools.com/xml/ajax_xmlhttprequest_create.asp
//     //         if(document.getElementById("statusID") == 2)
//     //             suspend.innerText = "Re-Activate";
//     //         else if(document.getElementById("statusID") == 1)
//     //             suspend.innerText = "Suspend";
//     //
//     //         // document.getElementById("movie" + id).style.display = none;
//     //     }
//     // };
//     // xhr.open("DELETE", "/a/users/" + id + '/suspend', true);
//     // console.log(">>> AJAX Suspend user AJAX request opened!!!")
//     // xhr.send();
// }


// To delete user when delete button is clicked

$(".btn-delete-user").click(function (e) {
    e.preventDefault();
    if(confirm("Are you sure?")) {
        var id = document.getElementById("userID").innerText;
        var tr = $(this).closest('tr');
        var del_id = tr.attr('zid');
        $.ajax({
            url: "/a/users/" + del_id,
            method: "DELETE",
            success: function (data) {
                // alert("Deleted a user with id = " + del_id);
                tr.remove();
            }
        });
    } // delete if 'OK' is clicked
    else {
        console.log("Not deleted user")
    }
});
