package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Player;
import kr.ac.kopo.gnuyog._026example.domain.Team;
import kr.ac.kopo.gnuyog._026example.repository.PlayerRepository;
import kr.ac.kopo.gnuyog._026example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exam14_04")
public class Chap14_04Controller
{
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public String requestInsert(Model model)
    {
        Team team = new Team();
        team.setName("토트넘");
        teamRepository.save(team);          // 1. 팀을 먼저 저장해요.

        Player player1 = new Player();
        player1.setName("손흥민");
        player1.setTeam(team);              // 2. 저장된 팀을 선수에 연결해요.
        playerRepository.save(player1);

        Player player2 = new Player();
        player2.setName("엄지성");
        player2.setTeam(team);
        playerRepository.save(player2);

        model.addAttribute("teamList", teamRepository.findAll());
        model.addAttribute("playerList", playerRepository.findAll());

        return "viewPage05";
    }
}