package cursofullstack.modulo5.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cursofullstack.modulo5.model.dto.NotasDto;


@Repository
@Transactional
public class NotasDaoImpl implements NotasDao {
	
	private String list = "SELECT * FROM notas ORDER BY alumno";
	private String select = "SELECT * FROM notas WHERE alumno=?";
	private String insert = "INSERT INTO notas VALUES (?,?,?,?,?,?)";
	private String update = "UPDATE notas SET curso=?, alumno=?, numero_modulo=?, numero_evaluacion=?," + 
			"nota=?, id_nota=? WHERE id_nota=?";
	private String delete = "DELETE notas WHERE id_nota=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<NotasDto> list() {
		List<NotasDto> listNotas = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(NotasDto.class));
		return listNotas;
	}

	@Override
	public NotasDto get(String alumno) {
		 Object[] args = {alumno};
		 NotasDto notasDto;
		    
		    try {
		    	notasDto = jdbcTemplate.queryForObject(select,args,
		    		BeanPropertyRowMapper.newInstance(NotasDto.class));
		    } catch (EmptyResultDataAccessException e) {
		    	notasDto=null;
		    	e.printStackTrace();
		    } catch (Exception e) {
		    	notasDto=null;
		    	e.printStackTrace();
		    }
		    return notasDto;
		}

	@Override
	public int insert(NotasDto notasDto) {
		int rows = 0;
	    Object[] args = {
	    		notasDto.getCurso(),
	    		notasDto.getAlumno(),
	    		notasDto.getNumeroModulo(),
	    		notasDto.getNumeroEvaluacion(),
	    		notasDto.getNota(),
	    		notasDto.getIdNota()
	    		
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}


	@Override
	public int update(NotasDto notasDto) {
		int rows = 0;
	    Object[] args = {
	    		notasDto.getCurso(),
	    		notasDto.getAlumno(),
	    		notasDto.getNumeroModulo(),
	    		notasDto.getNumeroEvaluacion(),
	    		notasDto.getNota(),
	    		notasDto.getIdNota(),
	    		notasDto.getIdNota(),
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}


	@Override
	public int delete(String idNota) {
		int rows = 0;
	    Object[] args = {idNota};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
