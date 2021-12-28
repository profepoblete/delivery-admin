var table = $('#simpleTable').DataTable({
    "ordering": true,
    "order": [[ 0, "desc" ]],
    "lengthMenu": [[5, 10, 20, 30, -1], ["5", "10", "20", "30", "Todos"]],
    //"iDisplayLength": 10,
    "scrollX": true,
    language: {
        "decimal": "",
        "emptyTable": "No se encuentran registros para esta tabla",
        "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
        "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
        "infoFiltered": "(Filtrado de _MAX_ total entradas)",
        "infoPostFix": "",
        "thousands": ",",
        "lengthMenu": "Entradas a mostrar: _MENU_",
        "loadingRecords": "Cargando...",
        "processing": "Procesando...",
        "search": "Buscar:",
        "zeroRecords": "Sin resultados encontrados",
        "paginate": {
            "first": "Primero",
            "last": "Ultimo",
            "next": "Siguiente",
            "previous": "Anterior"
        }
    }
});

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
});