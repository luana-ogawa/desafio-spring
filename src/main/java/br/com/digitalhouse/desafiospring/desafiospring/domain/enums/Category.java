package br.com.digitalhouse.desafiospring.desafiospring.domain.enums;

public enum Category {

    CADEIRAS(100),
    HEADSETS(120),
    TECLADOS(58),
    MOUSES(32);

    private int codigo;

    private Category(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static Category toEnum(Integer codigo) {

        if (codigo == null) {
            return null;
        }

        for (Category category : Category.values()) {
            if (codigo.equals(category.getCodigo())) {
                return category;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codigo);

    }

}
