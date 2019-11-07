package cn.ibm.com.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ibm.com.dao.entity.SbaUser;

public interface SbaUserRepository extends JpaRepository<SbaUser, Long> {

	public SbaUser findByName(String name);
}
