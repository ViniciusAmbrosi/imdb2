package com.sap.acme.imdb2.web.extension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.acme.imdb2.entity.Role;
import com.sap.acme.imdb2.web.model.RoleModel;

public class RoleExtensions {

	public static Role fromModel(RoleModel roleModel){
		Role role = new Role();
		role.setId(roleModel.getId());
		role.setName(roleModel.getName());
		return role;
	}
	
	public static Set<Role> fromModel(List<RoleModel> rolesModel){
		if(rolesModel == null || rolesModel.size() <= 0){
			return getDefaultRole();
		}
		Set<Role> roles = new HashSet<Role>();
		for(RoleModel roleModel : rolesModel){
			roles.add(fromModel(roleModel));
		}
		return roles;
	}
	
	public static RoleModel toModel(Role role){
		RoleModel roleModel = new RoleModel();
		roleModel.setId(role.getId());
		roleModel.setName(role.getName());
		return roleModel;
	}
	
	public static List<RoleModel> toModel(Set<Role> roles){
		List<RoleModel> rolesModel = new ArrayList<RoleModel>();
		for(Role role: roles){
			rolesModel.add(toModel(role));
		}
		return rolesModel;
	}
	
	public static Set<Role> getDefaultRole(){
		Role roleModel = new Role();
		Set<Role> roles = new HashSet<Role>();
		roleModel.setId(1L);
		roleModel.setName("ROLE_USER");
		roles.add(roleModel);
		return roles;
	}

}
