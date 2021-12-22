package com.raf.sk;

import com.raf.sk.domain.Rank;
import com.raf.sk.domain.Role;
import com.raf.sk.domain.User;
import com.raf.sk.repository.RankRepository;
import com.raf.sk.repository.RoleRepository;
import com.raf.sk.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner{

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private RankRepository rankRepository;

    public TestDataRunner(RoleRepository roleRepository,
                          UserRepository userRepository, RankRepository rankRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.rankRepository = rankRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
        //Insert ranks
        Rank rankBronze = new Rank("Bronze", 0, 0);
        Rank rankSilver = new Rank("Silver", 5, 10);
        Rank rankGold = new Rank("Gold", 10, 20);
        rankRepository.save(rankBronze);
        rankRepository.save(rankSilver);
        rankRepository.save(rankGold);
        //Insert admin
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.setRole(roleAdmin);
        admin.setIme("admin");
        admin.setPrezime("pera");

        userRepository.save(admin);
    }
}
