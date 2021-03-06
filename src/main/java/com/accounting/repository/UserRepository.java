package com.accounting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accounting.user.bo.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findUserByUsername(String username);
	User findUserByFacebookID(String facebookID);
	User findUserByEmail(String email);
	User findUserByUserId(Long userId);
	User findUserByEmailAndPassword(String email,String password);
	
	@Query("select u from User u where resetToken =:resetToken and HOUR(TIMEDIFF(resetTokenCreatedAt,now())) <= 1")
	User findByResetTokenAndResetTokenCreatedAt(@Param("resetToken") String resetToken);
	
	@Query("select u from User u where name LIKE CONCAT(:name,'%')")
	List<User> findUserByName(@Param("name") String name);
	
	@Query("select u from User u JOIN u.myAccounts ma where ma.mainCourseId like CONCAT('%',:mainCourseIds,'%') and ma.secondryCourseId like CONCAT('%',:secondryCourseIds,'%')")
	List<User> findByMainCourseIdsAndSecondryCourseIds(@Param("mainCourseIds") String mainCourseIds,@Param("secondryCourseIds") String secondryCourseIds);
	
}
