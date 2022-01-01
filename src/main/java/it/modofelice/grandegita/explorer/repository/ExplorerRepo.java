package it.modofelice.grandegita.explorer.repository;

import it.modofelice.grandegita.explorer.model.Explorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExplorerRepo extends JpaRepository<Explorer, Long> {

    void deleteExplorerById(Long id);

    Optional<Explorer> findExplorerById(Long id);
}
