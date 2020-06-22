function NotasController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");

	switch(opcion){
	case "listNotas":
		$.ajax({
			type : "post",
			url : "/notas/list",
			success : function(res) {
				$('#registrarTable').bootstrapTable('load', res);
				$('#registrarTable tbody').on('click', 'tr', function () {
					
					$("#curso").val($(this).find("td:eq(0)").text());
					$("#alumno").val($(this).find("td:eq(1)").text());
					
					$("#numeroModulo").val($(this).find("td:eq(2)").text());
					$("#numeroEvaluacion").val($(this).find("td:eq(3)").text());
					$("#nota").val($(this).find("td:eq(4)").text());
					$("#idNota").val($(this).find("td:eq(5)").text());
					
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true});
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de empleados.")
			}
		});       			
		break;
	case "getNotas":
		$.ajax({
			type : "post",
			url : "/notas/get",
			data : "alumno="+$("#alumno").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {	
					$("#curso").val(res.curso);
					$("#alumno").val(res.alumno);
					$("#numeroModulo").val(res.numeroModulo);
					$("#numeroEvaluacion").val(res.numeroEvaluacion);
					$("#nota").val(res.nota);
					$("#idNota").val(res.idNota);
					
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
		
	case "insertNotas":
		var json = 
			{
				'curso': $("#curso").val(),
				'alumno': $("#alumno").val(),
				'numeroModulo': $("#numeroModulo").val(),
				'numeroEvaluacion': $("#numeroEvaluacion").val(),
				'nota': $("#nota").val(),
				'idNota': $("#idNota").val()
				
			};
	
	    var postData = JSON.stringify(json);

	    $.ajax({
			type : "post",
			url : "/notas/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
	        dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro ingresado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo ingresar el registro.");
			}
		});       	
	    break;
	    
	case "updateNotas":
		var json = 
			{
			'curso': $("#curso").val(),
			'alumno': $("#alumno").val(),
			'numeroModulo': $("#numeroModulo").val(),
			'numeroEvaluacion': $("#numeroEvaluacion").val(),
			'nota': $("#nota").val(),
			'idNota': $("#idNota").val()
			};
		;

	    var postData = JSON.stringify(json);

		$.ajax({
			type : "post",
			url : "/notas/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro modificado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo modificar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo modificar el registro.");
			}
		});       	
    break;
	case "deleteNotas":
		$.ajax({
			type : "post",
			url : "/notas/delete",
			data : "idNota="+$("#idNota").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo eliminar el registro.");
			}
		});
		break;
	default:
		$("#msg").show();
		$("#msg").html("Opción incorrecta.");
	}
}
