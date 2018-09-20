package com.accounting.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="my_accounts")
public class MyAccount extends AccountingGeneral{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="my_account_id")
	private Long myAccountId;
	
	@Column(name="main_course_ids")
	private String mainCourseId;
	
	@Column(name="secondry_course_ids")
	private String secondryCourseId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="secondry_cource_id",insertable=false, updatable=false)
	private ProfileCategory secondryCourse;
	
	@Column(name="created_by_id")
	private Long createdById;
	
	@Column(name="is_news_letter_subscribed")
	private boolean isNewsLetterSubscribed = false;
	
	@Column(name="is_notification_on")
	private boolean isNotificationOn = false;
	
	@Column(name="is_accomodation_taken")
	private boolean isAccomodationTaken = false;
	
	@Column(name="is_meal_taken")
	private boolean isMealTaken = false;
	
	@Column(name="is_jobs_on")
	private boolean isJobsOn = false;
	
	@Column(name="is_coaching_ads_on")
	private boolean isCoachingAdsOn = false;
	
	@Column(name="is_statutes_on")
	private boolean isStatutesOn = false;
	
	@Column(name="account_city_ids")
	private String accountCityId;
	
	public Long getMyAccountId() {
		return myAccountId;
	}

	public void setMyAccountId(Long myAccountId) {
		this.myAccountId = myAccountId;
	}

	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	public ProfileCategory getSecondryCource() {
		return secondryCourse;
	}

	public void setSecondryCource(ProfileCategory secondryCourse) {
		this.secondryCourse = secondryCourse;
	}

	public String getMainCourseId() {
		return mainCourseId;
	}

	public void setMainCourseId(String mainCourseId) {
		this.mainCourseId = mainCourseId;
	}

	public String getSecondryCourseId() {
		return secondryCourseId;
	}

	public void setSecondryCourseId(String secondryCourseId) {
		this.secondryCourseId = secondryCourseId;
	}

	public ProfileCategory getSecondryCourse() {
		return secondryCourse;
	}

	public void setSecondryCourse(ProfileCategory secondryCourse) {
		this.secondryCourse = secondryCourse;
	}

	public boolean isNewsLetterSubscribed() {
		return isNewsLetterSubscribed;
	}

	public void setNewsLetterSubscribed(boolean isNewsLetterSubscribed) {
		this.isNewsLetterSubscribed = isNewsLetterSubscribed;
	}

	public boolean isNotificationOn() {
		return isNotificationOn;
	}

	public void setNotificationOn(boolean isNotificationOn) {
		this.isNotificationOn = isNotificationOn;
	}

	public boolean isAccomodationTaken() {
		return isAccomodationTaken;
	}

	public void setAccomodationTaken(boolean isAccomodationTaken) {
		this.isAccomodationTaken = isAccomodationTaken;
	}

	public boolean isMealTaken() {
		return isMealTaken;
	}

	public void setMealTaken(boolean isMealTaken) {
		this.isMealTaken = isMealTaken;
	}

	public boolean isJobsOn() {
		return isJobsOn;
	}

	public void setJobsOn(boolean isJobsOn) {
		this.isJobsOn = isJobsOn;
	}

	public boolean isCoachingAdsOn() {
		return isCoachingAdsOn;
	}

	public void setCoachingAdsOn(boolean isCoachingAdsOn) {
		this.isCoachingAdsOn = isCoachingAdsOn;
	}

	public boolean isStatutesOn() {
		return isStatutesOn;
	}

	public void setStatutesOn(boolean isStatutesOn) {
		this.isStatutesOn = isStatutesOn;
	}

	public String getAccountCityId() {
		return accountCityId;
	}

	public void setAccountCityId(String accountCityId) {
		this.accountCityId = accountCityId;
	}
	
	
}
