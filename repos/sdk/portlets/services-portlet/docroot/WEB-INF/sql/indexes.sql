create index IX_38FD2802 on hrm_applicable_employment_statuses (employmentStatusId);
create index IX_B2289A78 on hrm_applicable_employment_statuses (leaveTypeApplicabilityId);

create index IX_8FA072F1 on hrm_applicable_job_titles (jobTitleId);
create index IX_73D937CA on hrm_applicable_job_titles (leaveTypeApplicabilityId);

create index IX_C33EBDA1 on hrm_emp_workshift (employeeId);
create index IX_D22A6AA9 on hrm_emp_workshift (shiftId);

create index IX_CFE16A05 on hrm_locations_holidays (holidayId);
create index IX_288C26E2 on hrm_locations_holidays (locationId);

create index IX_9E586A71 on hrm_lra_employmentStatus (employmentStatusId);
create index IX_D0A8D079 on hrm_lra_employmentStatus (leaveRuleApplicableId);

create index IX_B19266A7 on hrm_lra_jobCategories (jobCategoryId);
create index IX_40149E9E on hrm_lra_jobCategories (leaveRuleApplicableId);

create index IX_C7FFC5C8 on hrm_lra_jobTitles (jobTitleId);
create index IX_66F6E1FF on hrm_lra_jobTitles (leaveRuleApplicableId);