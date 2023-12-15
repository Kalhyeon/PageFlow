package com.pageflow.dao.memberGrade;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pageflow.entity.memberGrade.MemberGrade;

@Mapper
public interface MemberGradeDao {

  // 멤버 등급 생성
  @Insert("INSERT INTO member_grade (grade_code, grade_name, point_rate) VALUES (member_grade_seq.NEXTVAL, #{gradeName}, #{pointRate})")
  public Integer MemberGradeSave(MemberGrade memberGrade);

  // 특정 멤버 등급 및 포인트 적립률 조회
  @Select("SELECT * FROM member_grade WHERE grade_code = #{gradeCode}")
  public MemberGrade findGradeByCode(Long gradeCode);

  // 회원 등급에 따른 포인트 적립률 조회
  @Select("SELECT point_rate FROM member_grade WHERE grade_code = #{gradeCode}")
  public Double findPointRateByGradeCode(Long gradeCode);

  // 사용자의 누적 구매금액 조회 (등업을 하기 위해 쿼리)
  @Select("SELECT SUM(order_price) FROM orders WHERE member_id = #{memberId}")
  public Long PurchaseTotal(String memberId);

  // 사용자의 회원등급 업데이트
  @Update("UPDATE member SET grade_code = #{gradeCode} WHERE member_id = #{memberId}")
  public Integer updateMemberGrade(String memberId, Long gradeCode);

  // 회원의 3달안에 구매금액 조회
  @Select("SELECT SUM(order_price) FROM orders WHERE member_id = #{memberId} AND order_date >= #{threeMonthsAgo}")
  public Long PurchaseTotalForLastThreeMonths(@Param("memberId") String memberId,
      @Param("threeMonthsAgo") LocalDateTime threeMonthsAgo);

  // 모든 등급
  @Select("select * from member_grade")
  public List<MemberGrade> getAllMemberGrade();

  // 특정 멤버 등급 이름 조회
  @Select("SELECT grade_name FROM member_grade WHERE grade_code = #{gradeCode}")
  public String findGradeNameByCode(Long gradeCode);

  // 회원의 등급을 가져오는 쿼리
  @Select("SELECT grade_code FROM member WHERE member_id = #{memberId}")
  public Long getGradeByMemberId(String memberId);

  // 등급 적립률을 가져오는 쿼리
  @Select("SELECT point_rate FROM member_grade WHERE grade_code = #{gradeCode}")
  public Double getPointRateByGradeCode(Long gradeCode);
}
