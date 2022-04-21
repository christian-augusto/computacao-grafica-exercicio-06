package christian_willian;

public class JGLU {
    // Retorna matriz identidade 4x4
    public float[] matrixIdentity() {

        float[][] identity = {
                { 1.0f, 0.0f, 0.0f, 0.0f },
                { 0.0f, 1.0f, 0.0f, 0.0f },
                { 0.0f, 0.0f, 1.0f, 0.0f },
                { 0.0f, 0.0f, 0.0f, 1.0f }
        };

        float[] plainIdentity = toPlainMatrix4x4(identity);

        return plainIdentity;
    }

    // Retorna o resultado da multiplicação das matrizes m1 e m0 (m1 . m0).
    // O resultado das matrizes m0 e m1 são matrizes 4x4.
    public float[] matrixMultiply(float[] m1, float[] m0) {
        float[][] matrixA = toSquareMatrix4x4(m1);

        float[][] matrixB = toSquareMatrix4x4(m0);

        float[][] result = multiplyMatrix4x4(matrixA, matrixB);

        float[] plainResult = toPlainMatrix4x4(result);

        return plainResult;
    }

    public float[] matrixTranslate(float x, float y, float z) {
        float[][] result = {
                { 1.0f, 0.0f, 0.0f, x },
                { 0.0f, 1.0f, 0.0f, y },
                { 0.0f, 0.0f, 1.0f, z },
                { 0.0f, 0.0f, 0.0f, 1.0f }
        };

        float[] plainResult = toPlainMatrix4x4(result);

        return plainResult;
    }

    //// Abaixo mais métodos auxiliares ////
    ////////////////////////////////////////

    public static float[][] toSquareMatrix4x4(float[] matrix) {
        float[][] square = new float[4][4];

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[j][i] = matrix[4 * i + j];
            }
        }

        return square;
    }

    public static float[] toPlainMatrix4x4(float[][] matrix) {
        float[] plain = new float[16];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                plain[4 * i + j] = matrix[j][i];
            }
        }

        return plain;
    }

    public static float[][] multiplyMatrix4x4(float[][] matrix1, float[][] matrix2) {
        float[][] result = new float[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float elem = 0;

                for (int k = 0; k < matrix1.length; k++) {
                    elem += matrix1[i][k] * matrix2[k][j];
                }

                result[i][j] = elem;
            }
        }

        return result;
    }
}
