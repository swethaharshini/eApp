create index IX_38FD2802 on hrm_applicable_employment_statuses (employmentStatusId);
create index IX_B2289A78 on hrm_applicable_employment_statuses (leaveTypeApplicabilityId);

create index IX_8FA072F1 on hrm_applicable_job_titles (jobTitleId);
create index IX_73D937CA on hrm_applicable_job_titles (leaveTypeApplicabilityId);

create index IX_C33EBDA1 on hrm_emp_workshift (employeeId);
create index IX_D22A6AA9 on hrm_emp_workshift (shiftId);

create index IX_CFE16A05 on hrm_locations_holidays (holidayId);
create index IX_288C26E2 on hrm_locations_holidays (locationId);