package main;

import javax.swing.*;
import java.awt.*;

public class ManagerMain extends JFrame {
    private JPanel mainPanel; // 주 패널
    private CardLayout cardLayout; // 패널 전환을 위한 레이아웃

    //패널 식별자 변수
    private static final String M_MAIN_PANEL = "매니저 메인 패널";
    private static final String PASSWORD_PANEL = "비밀번호 초기화 패널";

    public ManagerMain() { //생성자
        setTitle("매니저");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout 초기화
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 매니저 메인 패널 생성 및 추가
        JPanel passwordPanel = createMainPanel();
        mainPanel.add(passwordPanel, M_MAIN_PANEL);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        //첫 번째 메뉴
        JMenu ownerMenu = new JMenu("점주 관리");
        JMenuItem ownerAdd = new JMenuItem("추가");
        JMenuItem ownerDel = new JMenuItem("삭제");
        JMenuItem ownerList = new JMenuItem("리스트 보기");

        //두 번째 메뉴
        JMenu stats = new JMenu("통계 보기");

        //세 번째 메뉴
        JMenu logout = new JMenu("통계 보기");

        // 메뉴 아이템 클릭 이벤트 추가
        //이건 나중에 다른 것들을 구현하고 나서 이어주면 됨
        //menuItemMain.addActionListener(e -> cardLayout.show(mainPanel, M_MAIN_PANEL));
        //menuItemPassword.addActionListener(e -> cardLayout.show(mainPanel, PASSWORD_PANEL));

        // 메뉴에 항목 추가
        ownerMenu.add(ownerAdd);
        ownerMenu.add(ownerDel);
        ownerMenu.add(ownerList);

        menuBar.add(ownerMenu);
        menuBar.add(stats);
        menuBar.add(logout);

        // 메뉴바를 프레임에 추가
        setJMenuBar(menuBar);

        // 초기 화면은 매니저 메인 패널로 설정
        cardLayout.show(mainPanel, M_MAIN_PANEL);

        // 메인 패널을 프레임에 추가
        add(mainPanel);

        // 창 설정
        setSize(850, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //createAddPanel

    public JPanel createAddPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        return panel;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManagerMain();
            }
        });
    }
}
