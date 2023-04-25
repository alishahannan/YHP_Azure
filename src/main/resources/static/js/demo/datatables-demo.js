// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
    'columnDefs':[{
      'targets':[-1],
      'searchable':false
    }]
  });
});
