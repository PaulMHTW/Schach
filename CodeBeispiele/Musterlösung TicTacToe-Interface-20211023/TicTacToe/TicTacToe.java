/**
 * Regeln:
 *  - 2 Spieler
 *  - Feldgroesse = 3 x 3
 *  - Symbole = Kreis und Kreuz
 *  - Startsymbol = Kreis
 *
 * State Machine:
 *  1. Keine Symbole gewählt, Feld leer
 *  2. Ein Symbol gewählt
 *  3. Zweites Symbol gewählt
 *  4. Kreis setzen
 *  5. Kreuz setzen
 *  6. Gewonnen
 *  7. Fehlerzustand bei Exceptions
 */
public interface TicTacToe {
    /**
     * Ordnet einem Spieler ein Symbol zu
     * (Fuer Zustaende 2 und 3)
     *
     * @return ausgewaehltes Symbol
     * @throws SymbolBereitsBelegtException, falls das gewaehlte Symbol bereits vergeben ist
     * @throws StateException, wenn nicht im Zustand 2 oder 3
     */
    Symbol pick(String user, Symbol s) throws SymbolBereitsBelegtException, StateException;

    /**
     * aktuelles Symbol wird auf eine freie Position in dem Spielfeld gesetzt
     * (Fuer Zustaende 4 und 5, Zustandsuebergaenge zu 6 und 7 werden hier abgefragt)
     *
     * @return true, wenn erfolgreiches Setzen, sonst false
     * @throws FeldBelegtException, wenn das Feld an der Position bereits belegt ist
     * @throws PositionNichtInFeldException, wenn die Position sich nicht in dem Feld befindet
     * @throws StateException, wenn nicht im Zustand 4 oder 5
     */
    boolean set(Symbol s, Position p) throws FeldBelegtException, PositionNichtInFeldException, StateException;
}
