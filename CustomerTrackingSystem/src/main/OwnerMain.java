package main;

import javax.swing.*;
import java.awt.*;

public class OwnerMain extends JFrame {
    private JPanel mainPanel; // 주 패널
    private CardLayout cardLayout; // 패널 전환을 위한 레이아웃

    //패널 식별자 변수
    private static final String O_MAIN_PANEL = "점주 메인 화면 패널"; //빈 화면
    private static final String ADD_CUSTOMER_PANEL = "고객 추가 패널";
    private static final String LIST_CUSTOMER_PANEL = "고객 리스트 패널";
    private static final String O_STATS_PANEL = "통계 보기 패널";

    public OwnerMain() { //생성자
        setTitle("점주");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout 초기화
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //점주 메인 패널 생성 및 추가
        JPanel ownerMainPanel = createMainPanel();
        mainPanel.add(ownerMainPanel, ADD_CUSTOMER_PANEL);

        // 고객 추가 패널 생성 및 추가
        JPanel addCustomerPanel = createAddPanel();
        mainPanel.add(addCustomerPanel, ADD_CUSTOMER_PANEL);

        //고객 리스트 패널 생성 및 추가
        JPanel listCustomerPanel = createListPanel();
        mainPanel.add(listCustomerPanel, LIST_CUSTOMER_PANEL);

        //고객 리스트 패널 생성 및 추가
        JPanel statsPanel = createStatsPanel();
        mainPanel.add(statsPanel, O_STATS_PANEL);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        //첫 번째 메뉴
        JMenu customerMenu = new JMenu("고객 관리");
        JMenuItem customerAdd = new JMenuItem("추가");
        JMenuItem customerList = new JMenuItem("리스트 보기");

        //두 번째 메뉴
        JMenu stats = new JMenu("통계 보기");

        //세 번째 메뉴
        JMenu logout = new JMenu("로그아웃");

        // 메뉴 아이템 클릭 이벤트 추가
        customerAdd.addActionListener(e -> cardLayout.show(mainPanel, ADD_CUSTOMER_PANEL));
        customerList.addActionListener(e -> cardLayout.show(mainPanel, LIST_CUSTOMER_PANEL));

        // 마우스 클릭 이벤트 추가
        stats.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cardLayout.show(mainPanel, O_STATS_PANEL);
            }
        });

        // 메뉴에 항목 추가
        customerMenu.add(customerAdd);
        customerMenu.add(customerList);

        menuBar.add(customerMenu);
        menuBar.add(stats);
        menuBar.add(logout);

        // 메뉴바를 프레임에 추가
        setJMenuBar(menuBar);

        // 초기 화면은 매니저 메인 패널로 설정
        cardLayout.show(mainPanel, O_MAIN_PANEL);

        // 메인 패널을 프레임에 추가
        add(mainPanel);

        // 창 설정
        setSize(850, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //점주 메인 화면 패널을 생성하는 메소드
    public JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        return panel;
    }

    //고객 추가 패널을 생성하는 메소드
    public JPanel createAddPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("추가할 고객의 정보를 입력하세요", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 중앙 입력창 패널
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        String[] options = { " ", "option1" };

        // 성별 콤보박스
        JLabel genLabel = new JLabel("성별");
        genLabel.setOpaque(true);
        genLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        genLabel.setHorizontalAlignment(SwingConstants.CENTER);
        genLabel.setPreferredSize(new Dimension(120, 30));
        JComboBox<String> genComboBox = new JComboBox<>(new String[]{" ", "남성", "여성"});
        genComboBox.setPreferredSize(new Dimension(250, 30));
        genComboBox.setBackground(new Color(227, 232, 239));

        // 나이 콤보박스
        JLabel ageLabel = new JLabel("나이");
        ageLabel.setOpaque(true);
        ageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ageLabel.setPreferredSize(new Dimension(120, 30));
        JComboBox<String> ageComboBox = new JComboBox<>(options);
        ageComboBox.setPreferredSize(new Dimension(250, 30));
        ageComboBox.setBackground(new Color(227, 232, 239));

        // 입장 시간대 콤보박스
        JLabel entryTimeLabel = new JLabel("입장 시간대");
        entryTimeLabel.setOpaque(true);
        entryTimeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        entryTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        entryTimeLabel.setPreferredSize(new Dimension(120, 30));
        JComboBox<String> entryTimeComboBox = new JComboBox<>(options);
        entryTimeComboBox.setPreferredSize(new Dimension(250, 30));
        entryTimeComboBox.setBackground(new Color(227, 232, 239));

        // 머문 시간 콤보박스
        JLabel stayTimeLabel = new JLabel("머문 시간");
        stayTimeLabel.setOpaque(true);
        stayTimeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        stayTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        stayTimeLabel.setPreferredSize(new Dimension(120, 30));
        JComboBox<String> stayTimeComboBox = new JComboBox<>(options);
        stayTimeComboBox.setPreferredSize(new Dimension(250, 30));
        stayTimeComboBox.setBackground(new Color(227, 232, 239));

        // 총 구입 가격대 콤보박스
        JLabel totalPriceRangeLabel = new JLabel("총 구입 가격대");
        totalPriceRangeLabel.setOpaque(true);
        totalPriceRangeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        totalPriceRangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceRangeLabel.setPreferredSize(new Dimension(120, 30));
        JComboBox<String> totalPriceRangeComboBox = new JComboBox<>(options);
        totalPriceRangeComboBox.setPreferredSize(new Dimension(250, 30));
        totalPriceRangeComboBox.setBackground(new Color(227, 232, 239));

        // 항목별 라벨과 콤보박스 배치
        // 성별
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(genLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(genComboBox, gbc);

        // 나이
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(ageLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(ageComboBox, gbc);

        // 입장 시간대
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(entryTimeLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(entryTimeComboBox, gbc);

        // 머문 시간
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(stayTimeLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(stayTimeComboBox, gbc);

        // 총 구입 가격대
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(totalPriceRangeLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(totalPriceRangeComboBox, gbc);

        panel.add(inputPanel, BorderLayout.CENTER);

        // 하단 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        JButton confirmButton = new JButton("완료");
        confirmButton.setBackground(new Color(189, 204, 227));
        confirmButton.setPreferredSize(new Dimension(70, 30));
        buttonPanel.add(confirmButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    //고객 리스트 패널을 생성하는 메소드
    public JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 설명 라벨
        JLabel titleLabel = new JLabel("등록된 고객 리스트", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 중앙 패널에 스크롤이 가능한 리스트를 추가
        String[] ownerNames = {"ID : 0", "성별 : 여성", "나이 : 30대", "입장 시간대 : 14시", "머문 시간 : 1시간 30분", "총 구입 가격대 : 20만원", " ", " ",
                "ID : 1", "성별 : 남성", "나이 : 40대", "입장 시간 : 10시", "머문 시간 : 30분 이하", "총 구입 가격대 : 50만원", " ", " "};
        JList<String> ownerList = new JList<>(ownerNames);
        ownerList.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        ownerList.setEnabled(false);  // 읽기 전용

        JScrollPane scrollPane = new JScrollPane(ownerList);
        scrollPane.setPreferredSize(new Dimension(250, 200));

        // FlowLayout을 사용하는 패널에 스크롤 페인지를 감싸서 중앙으로 배치
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(scrollPane);

        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    //통계 패널을 생성하는 메소드
    public JPanel createStatsPanel() {
        // 메인 패널: BorderLayout을 사용하여 상단과 중앙을 나눕니다.
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // 상단 패널 (JComboBox 하나만 왼쪽에 배치)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topPanel.setBackground(Color.WHITE);

        // JComboBox
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"(기준 선택)", "성별", "나이", "입장 시간대"});
        topPanel.add(comboBox);
        panel.add(topPanel, BorderLayout.NORTH);

        // 중앙 그룹 패널 (3개의 컴포넌트가 화면을 가득 채우도록 설정)
        JPanel centerGroupPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        centerGroupPanel.setBackground(Color.WHITE);

        // 컴포넌트 1
        JPanel comp1 = new JPanel();
        comp1.setBackground(new Color(220, 240, 255));
        comp1.add(new JLabel("그래프 1"));

        // 컴포넌트 2
        JPanel comp2 = new JPanel();
        comp2.setBackground(new Color(220, 240, 255));
        comp2.add(new JLabel("그래프 2"));

        // 컴포넌트 3
        JPanel comp3 = new JPanel();
        comp3.setBackground(new Color(220, 240, 255));
        comp3.add(new JLabel("그래프 3"));

        // 그룹 패널에 컴포넌트 추가
        centerGroupPanel.add(comp1);
        centerGroupPanel.add(comp2);
        centerGroupPanel.add(comp3);

        // 화면을 채우기 위해 BorderLayout.CENTER에 추가
        panel.add(centerGroupPanel, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OwnerMain();
            }
        });
    }
}

