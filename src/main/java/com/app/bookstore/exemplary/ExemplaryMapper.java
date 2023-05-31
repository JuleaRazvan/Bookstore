package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExemplaryMapper {
	public Exemplary exemplaryCreateDTO2Exemplary(ExemplaryCreateDTO exemplaryCreateDTO) {
		Exemplary exemplary = new Exemplary();
		exemplary.setDate(exemplaryCreateDTO.getDate());
		exemplary.setCode(exemplaryCreateDTO.getCode());
		exemplary.setPageNumber(exemplaryCreateDTO.getPageNumber());
		return exemplary;
	}

	public ExemplaryGetDTO exemplary2ExemplaryGetDTO(Exemplary exemplary) {
		ExemplaryGetDTO exemplaryGetDTO = new ExemplaryGetDTO();
		exemplaryGetDTO.setId(exemplary.getId());
		exemplaryGetDTO.setDate(exemplary.getDate());
		exemplaryGetDTO.setCode(exemplary.getCode());
		exemplaryGetDTO.setPageNumber(exemplary.getPageNumber());
		return exemplaryGetDTO;
	}

	public List<ExemplaryGetDTO> exemplaryList2ExemplaryGetDTOList(List<Exemplary> exemplaryList){
		return exemplaryList.stream()
				.map(exemplary -> exemplary2ExemplaryGetDTO(exemplary))
				.toList();
	}
}
