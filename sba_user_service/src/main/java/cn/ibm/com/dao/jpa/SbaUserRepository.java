package cn.ibm.com.dao.jpa;

import cn.ibm.com.dao.entity.SbaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SbaUserRepository extends JpaRepository<SbaUser, Long> {

}
