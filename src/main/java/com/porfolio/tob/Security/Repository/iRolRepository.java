
package com.porfolio.tob.Security.Repository;

import com.porfolio.tob.Security.Entity.Rol;
import com.porfolio.tob.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
