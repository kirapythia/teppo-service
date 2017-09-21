package fi.espoo.pythia.backend.mappers;

import fi.espoo.pythia.backend.repos.ProjectRepository;
import fi.espoo.pythia.backend.repos.entities.Plan;
import fi.espoo.pythia.backend.repos.entities.Project;
import fi.espoo.pythia.backend.transfer.PlanValue;

public class PlanValueToPlanMapper {

	
	public static Plan planValueToPlan(PlanValue pv, Project project) {
		
		//get project_id 
		

		Plan p = new Plan();
		
		p.setPlanId(pv.getPlanId());
		p.setProject(project);
		p.setMainNo(pv.getMainNo());
		p.setSubNo(pv.getSubNo());
		p.setVersion(pv.getVersion());
				
//		p.setCreatedAt(pv.getCreatedAt());
//		p.setCreatedBy(pv.getCreatedBy());
//		p.setUpdatedAt(pv.getUpdatedAt());
//		p.setUpdatedBy(pv.getUpdatedBy());
		
		return p;
	}
	
}