# Engine Simples para Jogos em Java

Engine criada com fins didáticos para implementação de jogos usando Java e a biblioteca AWT.

## Como usar

Veja um exemplo completo de funcionamento [aqui](https://github.com/brunoapimentel/java-awt-game/blob/main/src/example).

### Carregando assets para o jogo

Coloque as imagens e sons desejados na pasta `src/assets` e atualize os valores na classe `engine.AssetLoader`

```
private String[] imagePaths = {"minha-imagem.png"};
private String[] audioPaths = {"meu-som.wav"};
```

### Inicializando a engine

```
public static void main(String[] args) {
    GameObject object = new GameObject(0, 100, AssetLoader.getImage("minha-imagem.png"));
    GameEngine gameEngine = new GameEngine(600, 600);
    gameEngine.add(object);
    gameEngine.start();
}
```

### Adicionando comportamento para objetos

#### Sobrescrevendo o método paint

Extenda a classe GameObject e sobrescreva o método paint.
```
public class MyObject extends GameObject {
    public MyObject(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void paint(Graphics g) {
        x ++; // faz com que o objeto se mova automaticamente para a direita
        super.paint(g);
    }
}

```

#### Uso de keypress
Os eventos de keypress são propagados para todos os objetos e podem ser utilizados ao sobrescrever a
função `onKeyPress`. 

```
@Override
public void onKeyPress(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_SPACE) {
        y ++;
    }
}
```