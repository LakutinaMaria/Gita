package it.modofelice.grandegita.explorer.repository;

import it.modofelice.grandegita.explorer.model.Explorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExplorerRepo extends JpaRepository<Explorer, UUID> {

    void deleteExplorerById(UUID id);

    Optional<Explorer> findExplorerById(UUID id);
}
