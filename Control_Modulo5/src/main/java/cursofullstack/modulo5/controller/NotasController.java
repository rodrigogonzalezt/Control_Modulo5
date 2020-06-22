package cursofullstack.modulo5.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import cursofullstack.modulo5.model.dto.*;
import cursofullstack.modulo5.service.NotasService;

@Controller
@RequestMapping(value="/notas")
public class NotasController {
	
	
	@Autowired
	NotasService notasService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<NotasDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<NotasDto> list = notasService.list();
		return list;
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody NotasDto ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		NotasDto job = notasService.get(req.getParameter("idNota"));
		return job;
	}
	
	
	@RequestMapping(value="/getPromedio")
	public @ResponseBody NotasDto ajaxGetPromedio(HttpServletRequest req, HttpServletResponse res) {
		NotasDto promedio = notasService.get(req.getParameter("curso"));
		return promedio;
	}
	
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = notasService.delete(req.getParameter("idNota"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			NotasDto alumno = new Gson().fromJson(requestData, NotasDto.class);
			rows = notasService.insert(alumno);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//
	
		return rows;
	}
	
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			NotasDto alumno = new Gson().fromJson(requestData, NotasDto.class);
			rows = notasService.update(alumno);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
}
