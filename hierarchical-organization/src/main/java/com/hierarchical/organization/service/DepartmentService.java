package com.hierarchical.organization.service;
import com.hierarchical.organization.domain.models.view.DepartmentView;

import java.util.Set;

public interface DepartmentService {
    Set<DepartmentView> getDepartmentsInfo();
}
