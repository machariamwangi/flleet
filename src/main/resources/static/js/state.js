$('document').ready(function (){
    $('table #editButton').on('click', function(event){
        event.preventDefault()
        //countries/findById/?id=...
        var href = $(this).attr('href');

        $.get(href, function (state, status){
            $('#idEdit').val(state.id);
            $('#ddlCountryEdit').val(state.countryid);
            $('#capitalEdit').val(state.capital);
            $('#codeEdit').val(state.code);
            $('#nameEdit').val(state.name);
            $('#detailsEdit').val(state.details);
        });
        $('#editModal').modal();
    });
    $('table #detailsButton').on('click', function (){
       event.preventDefault();
       var href = $(this).attr('href');
       $.get(href, function (state, status){
           $('#idDetails').val(state.id);
           $('#nameDetails').val(state.countryId);
           $('#detailsDetails').val(state.details);
           $('#lastModifiedByDetails').val(state.lastModified);
           // $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0, 19).replace("T", ""));
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
