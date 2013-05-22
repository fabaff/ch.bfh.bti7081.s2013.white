package ch.bfh.ti.soed.white.mhc_pms.security;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;

public class PmsPermission {
	
	private static class PermissionKey {
		
		private UserGroup userGroup;
		
		private Element elementName;
		
		private PermissionKey(UserGroup userGroup, Element elementName) {
			this.userGroup = userGroup;
			this.elementName = elementName;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((elementName == null) ? 0 : elementName.hashCode());
			result = prime * result
					+ ((userGroup == null) ? 0 : userGroup.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			PermissionKey other = (PermissionKey) obj;
			if (elementName != other.elementName) {
				return false;
			}
			if (userGroup != other.userGroup) {
				return false;
			}
			return true;
		}

	}

	public static enum Element {
		NEW_PATIENT, NEW_CASE, EDIT_CASE, NEW_PATIENT_PROGRESS_ENTRY, EDIT_PATIENT_PROGRESS_ENTRY, DELETE_PATIENT_PROGRESS_ENTRY, 
		NEW_DIAGNOSIS, EDIT_DIAGNOSIS, DELETE_DIAGNOSIS, NEW_MEDICATION, EDIT_MEDICATION, DELETE_MEDICATION
	}
	
	private static Set<PermissionKey> permissionsSet = new HashSet<PermissionKey>();
	
	static {
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.NEW_MEDICATION));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.EDIT_MEDICATION));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.DELETE_MEDICATION));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.NEW_DIAGNOSIS));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.EDIT_DIAGNOSIS));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.DELETE_DIAGNOSIS));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.NEW_PATIENT_PROGRESS_ENTRY));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.EDIT_PATIENT_PROGRESS_ENTRY));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.DELETE_PATIENT_PROGRESS_ENTRY));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.EDIT_CASE));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.NEW_CASE));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHIATRIST, Element.NEW_PATIENT));
		
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST , Element.NEW_DIAGNOSIS));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.EDIT_DIAGNOSIS));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.DELETE_DIAGNOSIS));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.NEW_PATIENT_PROGRESS_ENTRY));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.EDIT_PATIENT_PROGRESS_ENTRY));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.DELETE_PATIENT_PROGRESS_ENTRY));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.EDIT_CASE));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.NEW_CASE));
		permissionsSet.add(new PermissionKey(UserGroup.PSYCHOLOGIST, Element.NEW_PATIENT));
		
		permissionsSet.add(new PermissionKey(UserGroup.ADMIN_STAFF, Element.NEW_CASE));
		permissionsSet.add(new PermissionKey(UserGroup.ADMIN_STAFF, Element.NEW_PATIENT));
	}
	
	private UserGroup userGroup;
	
	public PmsPermission(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public boolean hasPermission(Element elementName) {
		return permissionsSet.contains(new PermissionKey(this.userGroup, elementName));
	}
}
