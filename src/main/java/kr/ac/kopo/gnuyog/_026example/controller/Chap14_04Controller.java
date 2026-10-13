package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Player;
import kr.ac.kopo.gnuyog._026example.domain.Team;
import kr.ac.kopo.gnuyog._026example.repository.PlayerRepository;
import kr.ac.kopo.gnuyog._026example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("exam14_04")
public class Chap14_04Controller
{
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    // 목록 화면 (저장 코드 없이 조회만 해요)
    @GetMapping
    public String list(Model model)
    {
        model.addAttribute("teamList", teamRepository.findAll());
        model.addAttribute("playerList", playerRepository.findAll());
        return "viewPage05";
    }

    // 선수 추가
    @PostMapping("/player")
    public String addPlayer(@RequestParam("name") String name,
                            @RequestParam("teamId") Integer teamId)
    {
        Team team = teamRepository.findById(teamId).orElseThrow();
        // 선택한 팀 id로 DB에서 팀을 찾아요. 없으면 오류가 나요.

        Player player = new Player();
        player.setName(name);
        player.setTeam(team);
        playerRepository.save(player);

        return "redirect:/exam14_04";
        // 저장 후 목록 화면으로 돌아가요.
    }

    // 팀 추가 (필요하면 사용)
    @PostMapping("/team")
    public String addTeam(@RequestParam("name") String name)
    {
        Team team = new Team();
        team.setName(name);
        teamRepository.save(team);
        return "redirect:/exam14_04";
    }
}