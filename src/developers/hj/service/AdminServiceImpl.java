package developers.hj.service;

import java.util.ArrayList;

//import com.sun.marlin.DDasher;

import developers.hj.db.DBServiceImpl;
import developers.hj.Controller.MovieController;
import developers.hj.Controller.ResvController;
import developers.hj.db.DBService;
import developers.hj.mainClass.SecondPage;
import developers.hj.mainClass.mem.FindMem;
import developers.hj.mainClass.mem.ViewMem;
import developers.hj.mainClass.movie.AddMovie;
import developers.hj.mainClass.movie.FindMovName;
import developers.hj.mainClass.resv.FindDelMem;
import developers.hj.mainClass.resv.FindResvInfo;
import developers.hj.mainClass.resv.ResvMenu;
import dto.AdminDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import dto.ResvDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

public class AdminServiceImpl implements AdminService {
	Parent root;

	FindMovName fn = new FindMovName();
	SecondPage sp = new SecondPage();
	ViewMem vm = new ViewMem();
	FindMem fm = new FindMem();
	AddMovie am = new AddMovie();
	DBService ds;
	ObservableList<String> listString;
	ObservableList<String> showString;
	ListView listView;
	ListView showList;
	ArrayList<MemberDTO> allMem;
	String s;

	public AdminServiceImpl() {
		ds = new DBServiceImpl();
	}

	public void setRoot(Parent root) {
		this.root = root;

	}

	@Override
	public void login() {
		try {
			int next = check();
			if (next == 1) {
				sp.adminWorkspace();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("잘못된 정보입니다.");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewMem() {
		vm.select();
	}

	@Override
	public void addMovie() {
		am.setMovie();
	}

	@Override
	public void deleteMovie() {
		fn.findName();
	}

	@Override
	public void resrvInfo() {
		ResvMenu rm = new ResvMenu();
		rm.showMenu();
	}

	private String getId() {
		TextField id = (TextField) root.lookup("#adminId");
		return id.getText();
	}

	private String getPwd() {
		PasswordField pwd = (PasswordField) root.lookup("#adminPwd");
		return pwd.getText();
	}

	private String getMemNo() {
		PasswordField memNo = (PasswordField) root.lookup("#memNo");
		return memNo.getText();
	}

	private int check() {
		AdminDTO dto = ds.getAdminInfo(getId());
		int i = 0;
		if (dto != null) {
			if (dto.getId().equals(getId()) && dto.getPwd().equals(getPwd()) && dto.getMemNo().equals(getMemNo())) {
				i = 1;
			}
		} else {
			i = 0;
		}
		return i;
	}

	@Override
	public void viewOneMem() {
		fm.search();
	}

	private String findName() {
		TextField name = (TextField) root.lookup("#findMem");
		return name.getText();

	}

	@Override
	public void viewAllMem() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/viewAll.fxml"));
			Parent viewroot = null;
			try {
				viewroot = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Scene scene = new Scene(viewroot);
			Stage s = (Stage) root.getScene().getWindow();
			s.setScene(scene);
			s.show();

			listView = (ListView) viewroot.lookup("#listView");
			showList = (ListView) viewroot.lookup("#showList");
			Button button = (Button)viewroot.lookup("#close");
			setListView();
			setListViewEvent();
			button.setOnMouseClicked(e ->{
				s.close();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setListView() {
		try {
			listString = FXCollections.observableArrayList();
			allMem = ds.getAllInfo();
			for (int i = 0; i < allMem.size(); i++) {
				listString.add(i, "이름: " + allMem.get(i).getName());
			}
			listView.setItems(listString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setListViewEvent() {
		listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldValue, newValue) -> {
			System.out.println("old: " + oldValue);
			System.out.println("new: " + newValue);
			System.out.println("선택 값: " + listString.get((int) newValue));
			showString = FXCollections.observableArrayList();
			allMem = ds.getAllInfo();
			showString.add("이름: " + allMem.get((int) newValue).getName());
			showString.add("아이디: " + allMem.get((int) newValue).getId());
			showString.add("이메일: " + allMem.get((int) newValue).getEmail());
			showString.add("패스워드질문: " + allMem.get((int) newValue).getPwdQuestion());
			showString.add("패스워드 답: " + allMem.get((int) newValue).getPwdAnswer());
			showList.setItems(showString);

		});
	}

	@Override
	public void find() {
		try {
			String n = findName();
			MemberDTO dto = ds.getMemInfo(n);
			if (dto.getName().equals(n)) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/viewOne.fxml"));
				Parent viewroot = null;
				try {
					viewroot = loader.load();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(viewroot);
				Stage s = (Stage) root.getScene().getWindow();
				s.setScene(scene);
				s.show();

				TextField id = (TextField) viewroot.lookup("#showId");
				TextField email = (TextField) viewroot.lookup("#showEmail");
				TextField name = (TextField) viewroot.lookup("#showName");
				TextField pwdQ = (TextField) viewroot.lookup("#showQ");
				TextField pwdA = (TextField) viewroot.lookup("#showA");
				Button button = (Button)viewroot.lookup("#close");

				id.setText(dto.getId());
				name.setText(dto.getName());
				email.setText(dto.getEmail());
				pwdA.setText(dto.getPwdAnswer());
				pwdQ.setText(dto.getPwdQuestion());
				button.setOnMouseClicked(e ->{
					s.close();
				});

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("존재하지 않는 회원입니다.");
				alert.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void movieSave() {
		MovieDTO dto = new MovieDTO();
		TextField title = (TextField) root.lookup("#movieName");
		TextField info = (TextField) root.lookup("#movieInfo");
		TextField nation = (TextField) root.lookup("#movieNation");
		TextField dir = (TextField) root.lookup("#movieDir");
		TextField act = (TextField) root.lookup("#movieActor");
		TextField rate = (TextField) root.lookup("#movieRate");
		TextField rt = (TextField) root.lookup("#movieRt");
		DatePicker dp = (DatePicker) root.lookup("#movieRd");

		dto.setTitle(title.getText());
		dto.setInfomation(info.getText());
		dto.setActor(act.getText());
		dto.setDirector(dir.getText());
		dto.setNation(nation.getText());
		dto.setFilmRate(rate.getText());
		String strDate = dp.getValue().toString();
		dto.setMovieDate(strDate);
		dto.setRunningTime(Integer.parseInt(rt.getText()));
		int result = ds.setMoiveInfo(dto);

		if (result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("저장 성공");
			alert.show();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("저장 실패");
			alert.show();
		}
	}

	@Override
	public void searchMovie() {
		String name = findMovie();
		MovieDTO dto = ds.getMovieInfo(name);
		if (dto.getTitle().equals(name)) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/ShowMovieInfo.fxml"));
			Parent viewroot = null;
			try {
				viewroot = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Scene scene = new Scene(viewroot);
			
			MovieController m = loader.getController();
			m.setRoot(viewroot);
			
			Stage s = (Stage) root.getScene().getWindow();
			s.setScene(scene);
			s.show();
			
			TextField movname = (TextField) viewroot.lookup("#movieName");
			TextField info = (TextField) viewroot.lookup("#info");
			TextField rate = (TextField) viewroot.lookup("#rate");
			TextField dir = (TextField) viewroot.lookup("#dir");
			TextField actor = (TextField) viewroot.lookup("#actor");
			TextField time = (TextField) viewroot.lookup("#time");
			TextField date = (TextField) viewroot.lookup("#date");
			TextField nation = (TextField) viewroot.lookup("#nation");
			Button button = (Button) viewroot.lookup("#dd");

			movname.setText(dto.getTitle());
			info.setText(dto.getInfomation());
			rate.setText(dto.getFilmRate());
			dir.setText(dto.getDirector());
			actor.setText(dto.getActor());
			time.setText(dto.getRunningTime() + "분");
			date.setText(dto.getMovieDate());
			nation.setText(dto.getNation());
			
			button.setOnMouseClicked(e -> {
				s.close();
				
			});
			
		} else if(!dto.getTitle().equals(name)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("존재하지 않는 영화입니다.");
			alert.show();
		}
	}
	
	private String findMovie() {
		TextField name = (TextField) root.lookup("#movieName");
		return name.getText();
	}
	
	
	@Override
	public void confirmDelete() {
		try {
			TextField name = (TextField) root.lookup("#movieName");
			int result = ds.deleteMovie(name.getText());
			if (result == 1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("삭제 완료");
				alert.show();
				System.out.println(result);
				System.out.println();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("삭제 실패");
				alert.show();
				System.out.println(result);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void findId() {
		FindResvInfo fr = new FindResvInfo();
		fr.showInfo();
	}
	
	private String fId() {
		TextField id = (TextField)root.lookup("#id");
		return id.getText();
	}
	private String fNo() {
		TextField no = (TextField)root.lookup("#no");
		return no.getText();
	}
	@Override
	public void cancelResv() {
		String id = fId();
		String Rno = fNo();
		ResvDTO dto = ds.getResvINFO(id);
		if(dto !=null && dto.getId().equals(id) && dto.getResvNo().equals(Rno)) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/DelResv.fxml"));
			Parent viewroot = null;
			try {
				viewroot = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResvController r = loader.getController();
			r.setRoot(viewroot);
			
			Scene scene = new Scene(viewroot);
			Stage s = (Stage) root.getScene().getWindow();
			s.setScene(scene);
			s.show();
			
			TextField uId = (TextField) viewroot.lookup("#id");
			TextField amount =(TextField) viewroot.lookup("#amount");
			TextField pmethod = (TextField) viewroot.lookup("#pmethod");
			TextField pday = (TextField) viewroot.lookup("#pday");
			TextField seat = (TextField) viewroot.lookup("#seat");
			TextField theater = (TextField) viewroot.lookup("#theater");
			TextField date = (TextField) viewroot.lookup("#date");
			TextField no = (TextField) viewroot.lookup("#no");
			TextField title = (TextField) viewroot.lookup("#title");
			Button button = (Button) viewroot.lookup("#close");
			
			uId.setText(dto.getId());
			amount.setText(dto.getAmount()+"원");
			pmethod.setText(dto.getPayWith());
			pday.setText(dto.getPaymentDay());
			seat.setText(dto.getSeatNum().toString());
			theater.setText(dto.getTheater());
			date.setText(dto.getResvDate());
			no.setText(dto.getResvNo());
			title.setText(dto.getTitle());
			
			button.setOnMouseClicked(e ->{
				s.close();
			});
		}	
		
	}
	
	@Override
	public void showResvInfo() {
		String id = fId();
		ResvDTO dto = ds.getResvINFO(id);
		if(dto !=null && dto.getId().equals(id)) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/developers/hj/fxml/showResv.fxml"));
			Parent viewroot = null;
			try {
				viewroot = loader.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Scene scene = new Scene(viewroot);
			Stage s = (Stage) root.getScene().getWindow();
			s.setScene(scene);
			s.show();
			
			TextField uId = (TextField) viewroot.lookup("#id");
			TextField amount =(TextField) viewroot.lookup("#amount");
			TextField pmethod = (TextField) viewroot.lookup("#pmethod");
			TextField pday = (TextField) viewroot.lookup("#pday");
			TextField seat = (TextField) viewroot.lookup("#seat");
			TextField theater = (TextField) viewroot.lookup("#theater");
			TextField date = (TextField) viewroot.lookup("#date");
			TextField no = (TextField) viewroot.lookup("#no");
			TextField title = (TextField) viewroot.lookup("#title");
			Button button = (Button) viewroot.lookup("#close");
			
			uId.setText(dto.getId());
			amount.setText(dto.getAmount()+"원");
			pmethod.setText(dto.getPayWith());
			pday.setText(dto.getPaymentDay());
			seat.setText(dto.getSeatNum().toString());
			theater.setText(dto.getTheater());
			date.setText(dto.getResvDate());
			no.setText(dto.getResvNo());
			title.setText(dto.getTitle());
			
			button.setOnMouseClicked(e ->{
				s.close();
			});
		}	
	}

	@Override
	public void findDelId() {
		FindDelMem fd = new FindDelMem();
		fd.delMemSearch();
	}

	@Override
	public void confirmCancel() {
		TextField id = (TextField)root.lookup("#id");
		int result = ds.deleteResv(id.getText());
		if(result == 1) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("예매 취소 완료");
			alert.show();
		}
		
	}




}
