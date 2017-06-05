package org.mimba.bao.dao;

import org.mimba.bao.entities.Imagerie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IImagerieRepository extends JpaRepository<Imagerie, Long> {

	@Query("select i from Imagerie i where i.libelle like:mc")
	public Page<Imagerie> imageLibelleParMC(@Param("mc") String mc, Pageable pageable);

	public Page<Imagerie> findByLibelle(@Param("libelle") String libelle, Pageable pageable);

	@Query("select i from Imagerie i where i.remarque like:mc")
	public Page<Imagerie> imageRemarqueParMC(@Param("mc") String mc, Pageable pageable);
	
	public Page<Imagerie> findById(@Param("id") Long id, Pageable pageable);
	
	@Query("select i from Imagerie i where i.patient.id=:id")
	public Page<Imagerie> listeImageriePatient(@Param("id") Long id, Pageable pageable);
	
	@Query("select i from Imagerie i where i.casASuivre.id=:id")
	public Page<Imagerie> listeImagerieCasASuivre(@Param("id") Long id, Pageable pageable);
	
}
