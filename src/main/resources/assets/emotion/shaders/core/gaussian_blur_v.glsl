#version 150

uniform sampler2D Sampler0;
uniform vec2 Direction;
uniform float Radius;

in vec2 texCoord;
out vec4 fragColor;

float gaussian(float x, float sigma) {
    return exp(-(x * x) / (2.0 * sigma * sigma)) / (2.0 * 3.14159265 * sigma * sigma);
}

void main() {
    float sigma = Radius / 2.0;
    vec2 texelSize = 1.0 / vec2(textureSize(Sampler0, 0));
    vec4 result = vec4(0.0);
    float total = 0.0;

    for (float i = -Radius; i <= Radius; i++) {
        float weight = gaussian(i, sigma);
        vec2 offset = Direction * texelSize * i;
        result += texture(Sampler0, texCoord + offset) * weight;
        total += weight;
    }

    fragColor = result / total;
}
