package site.metacoding.projecttest.openapi.contents.field;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DownloadContentsField {
    // 어노테이션으로 자동으로 생성자를 통한 DI받기 위해 static 사용
    private final ContentsFieldRepository contentsfieldRepository;

    // 도메인 입력시 다운로드 할 수 있는 페이지로 이동시켜주는 메서드
    @GetMapping("/")
    public String main() {
        return "contentsfield/download";
    }

    // 데이터를 다운받아 DB에 저장하는 메서드
    @GetMapping("/download")
    public String download() {
        // 다운로드
        RestTemplate rt = new RestTemplate();

        StringBuffer sb = new StringBuffer();

        sb.append("http://www.pettravel.kr/api/listArea.do?");
        sb.append("page="); // 페이지
        sb.append("1");
        sb.append("&pageBlock="); // 페이지
        sb.append("10");
        sb.append("&areaCode="); // 아리아코드
        sb.append("AC01");

        // ResponseEntity<Item[]> response = rt.getForEntity(sb.toString(),
        // Item[].class);
        ContentsField[] response = rt.getForObject(sb.toString(), ContentsField[].class);

        List<ContentsField> contentsfield = Arrays.asList(response);

        // DB에 saveALL() + model에 담기
        contentsfieldRepository.saveAll(contentsfield);

        return "/";
    }

    // DB로부터 데이터를 불러와 리스트페이지로 전달하는 메서드
    @GetMapping("/list")
    public String list(Model model) {

        // DB로부터 데이터 받기
        List<ContentsField> contentsfield = contentsfieldRepository.findAll();

        // model에 담아 리스트페이지로 전달
        model.addAttribute("contentsfield", contentsfield);

        return "contentsfield/list";
    }

    // PK(id)로 DB에서 SELECT하여 VIEW에 전달하는 메서드
    @GetMapping("/detail/{contentSeq}")
    public String detail(@PathVariable int contentSeq, Model model) {

        // DB로부터 SELECT
        // null값도 담기 위해 Optional 사용
        Optional<ContentsField> opContentsfield = contentsfieldRepository.findById(contentSeq);

        // 데이터가 있다면 model에 담아 view로 전달
        if (opContentsfield.isPresent()) {
            ContentsField contentsfieldEntity = opContentsfield.get();
            model.addAttribute("contentsfield", contentsfieldEntity);

            return "contentsfield/detail";
        } else {
            return "contentsfield/list";
        }
    }
}