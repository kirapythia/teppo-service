package fi.espoo.pythia.backend.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.espoo.pythia.backend.repos.entities.Plan;
import fi.espoo.pythia.backend.repos.entities.Project;
import fi.espoo.pythia.backend.repos.entities.SisterProject;
import fi.espoo.pythia.backend.transfer.PlanValue;
import fi.espoo.pythia.backend.transfer.ProjectValue;
import fi.espoo.pythia.backend.transfer.ProjectValue2;

public class PrjVal2ToPrj {

	public static Project projectValue2ToProject(ProjectValue2 pv, Project project) {

		// current data
		Project p = new Project();

		p.setProjectId(pv.getProjectId());
		p.setHansuProjectId(pv.getHansuProjectId());
		p.setMainNo(pv.getMainNo());
		p.setName(pv.getName());
		p.setDescription(pv.getDescription());
		p.setCompleted(pv.isCompleted());
		p.setCreatedAt(new Date());

		try {
			List<Plan> plans = new ArrayList();
			for (PlanValue pp : pv.getPlans()) {
				plans.add(PlanValueToPlanMapper.planValueToPlan(pp, p));
			}
			p.setPlans(plans);
		} catch (java.lang.NullPointerException e) {
			p.setPlans(new ArrayList<Plan>());
		}

		try {
			p.setSisterProjects(project.getSisterProjects());

		} catch (java.lang.NullPointerException e) {
			p.setSisterProjects(new ArrayList());

		}
		// try {
		// List<SisterProject> sProjects = project.getSisterProjects();
		//
		// for (int i = 0; i < pv.getSisterProjects().size(); i++) {
		// System.out.println("pvgetsisterprojectid" +
		// pv.getSisterProjects().get(i));
		// sProjects.get(i).setSisterProjectId(pv.getSisterProjects().get(i));
		// }
		// p.setSisterProjects(sProjects);
		// } catch (java.lang.NullPointerException e) {
		// p.setSisterProjects(project.getSisterProjects());
		// } catch (java.lang.IndexOutOfBoundsException e) {
		// p.setSisterProjects(project.getSisterProjects());
		// }

		// p.setCreatedAt(pv.getCreatedAt());
		// p.setCreatedBy(pv.getCreatedBy());
		// p.setUpdatedAt(pv.getUpdatedAt());
		// p.setUpdatedBy(pv.getUpdatedBy());

		return p;
	}
}