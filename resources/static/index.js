$("button").submit(function() {
    var formData = JSON.stringify($("#myForm").serializeArray());

    $.ajax({
        type: "POST",
        url: "/sendEmail",
        data: formData,
        success: function () {
        },
        dataType: "json",
        contentType: "application/json"
    });
});