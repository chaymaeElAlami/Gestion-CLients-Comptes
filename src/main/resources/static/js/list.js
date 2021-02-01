function deleteCompte(id,index){
swal({
  title: "\n" +
      "Êtes-vous sûr?",
  text: "\n" +
      "Une fois supprimé, vous ne pourrez pas récupérer ce compte !",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
  		$.ajax({
            url: "/delete-compte/"+id,
            type: "GET",
            //data:  {"action":"deleteCompte","id" : id},
            success: function(){
                $("#"+id).remove();
                 swal("Compte supprimé", {
      				icon: "success",
   				 });
            },
            error: function(){
                alert("error");
            }          
		});
  } else {
    swal("Compte non supprimé");
  }
});
}

function deleteClient(id,index){
swal({
  title: "Êtes-vous sûr?",
  text: "Une fois supprimé, vous ne pourrez pas récupérer ce client !",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
  		$.ajax({
            url: "/delete-client/"+id,
            type: "GET",
            //data:  {"action":"deleteClient","id" : id},
            success: function(){
                $("#"+id).remove();
                 swal("Client supprimé", {
      				icon: "success",
   				 });
            },
            error: function(){
                alert("error");
            }          
		});
  } else {
    swal("Client non supprimé");
  }
});
}
