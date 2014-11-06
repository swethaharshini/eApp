create table hrm_Job (
	jobId LONG not null primary key,
	jobTitleId LONG,
	jobCategoryId LONG,
	subUnitId LONG,
	locationId LONG,
	employmentStatusId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	joinedDate DATE null,
	employmentContractStartDate DATE null,
	employmentContractEndDate DATE null,
	contractDetails BLOB
);

create table hrm_Nationality (
	nationalityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	Name VARCHAR(75) null
);

create table hrm_applicable_employment_statuses (
	employmentStatusId LONG not null,
	leaveTypeApplicabilityId LONG not null,
	primary key (employmentStatusId, leaveTypeApplicabilityId)
);

create table hrm_applicable_job_titles (
	jobTitleId LONG not null,
	leaveTypeApplicabilityId LONG not null,
	primary key (jobTitleId, leaveTypeApplicabilityId)
);

create table hrm_emp_workshift (
	employeeId LONG not null,
	shiftId LONG not null,
	primary key (employeeId, shiftId)
);

create table hrm_locations_holidays (
	holidayId LONG not null,
	locationId LONG not null,
	primary key (holidayId, locationId)
);

create table supervisor (
	supervisorId LONG not null primary key,
	employeeId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	reportingMethod LONG
);