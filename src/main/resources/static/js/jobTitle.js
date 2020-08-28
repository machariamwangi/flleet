$('document').ready(function (){
    $('table #editButton').on('click', function(event){
        event.preventDefault()
        //countries/findById/?id=...
        var href = $(this).attr('href');

        $.get(href, function (state, status){
            $('#idEdit').val(jobTitle.id);
            $('#descriptionEdit').val(jobTitle.description);
            $('#detailsEdit').val(jobTitle.details);
        });
        $('#editModal').modal();
    });
    $('table #detailsButton').on('click', function (){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (jobTitle, status){
            $('#idDetails').val(jobTitle.id);
            $('#descriptionDetails').val(jobTitle.description);
            $('#detailsDetails').val(jobTitle.details);
            $('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
            $('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    })
});
