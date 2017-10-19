package fi.espoo.pythia.backend.mappers;

import java.time.OffsetDateTime;

import fi.espoo.pythia.backend.repos.entities.Plan;
import fi.espoo.pythia.backend.repos.entities.ProjectUpdate;
import fi.espoo.pythia.backend.transfer.PlanValue;

public class PlanValueToPlanMapper {

	
	public static Plan planValueToPlan(PlanValue pv, ProjectUpdate project, boolean updating) {
		
		//get project_id 
		

		Plan p = new Plan();
		
		p.setPlanId(pv.getPlanId());
		p.setProject(project);
		p.setMainNo(pv.getMainNo());
		p.setSubNo(pv.getSubNo());
		p.setVersion(pv.getVersion());
		p.setUrl(pv.getUrl());
		p.setStatus(pv.getStatus());
		
		if (updating == false) {
			p.setCreatedAt(OffsetDateTime.now());
		} else {
			p.setCreatedAt(pv.getCreatedAt());
		}

		p.setCreatedBy(pv.getCreatedBy());
		p.setUpdatedAt(OffsetDateTime.now());
		p.setUpdatedBy(pv.getUpdatedBy());
		p.setDeleted(pv.isDeleted());
		
		return p;
	}
	
}
