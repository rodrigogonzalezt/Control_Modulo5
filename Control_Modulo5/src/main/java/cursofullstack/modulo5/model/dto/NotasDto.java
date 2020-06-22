package cursofullstack.modulo5.model.dto;

public class NotasDto {
	
	private String curso;
	private String alumno;
	private Integer numeroModulo;
	private Integer numeroEvaluacion;
	private Integer nota;
	private String idNota;
	private Integer promedio;
	
	
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public Integer getNumeroModulo() {
		return numeroModulo;
	}
	public void setNumeroModulo(Integer numeroModulo) {
		this.numeroModulo = numeroModulo;
	}
	public Integer getNumeroEvaluacion() {
		return numeroEvaluacion;
	}
	public void setNumeroEvaluacio(Integer numeroEvaluacion) {
		this.numeroEvaluacion = numeroEvaluacion;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public String getIdNota() {
		return idNota;
	}
	public void setIdNota(String idNota) {
		this.idNota = idNota;
	}
	
	public Integer getPromedio() {
		return promedio;
	}
	
	
	
	
	

}
