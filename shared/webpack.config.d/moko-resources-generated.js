const path = require('path');

const mokoResourcePath = path.resolve("C:\Users\andrea\work\dialexa\mnp\mnp-mobile-app\shared\build\generated\moko\jsMain\comdialexamnp\res");

config.module.rules.push(
    {
        test: /\.(.*)/,
        include: [
            path.resolve(mokoResourcePath)
        ],
        type: 'asset/resource'
    }
);

config.module.rules.push(
    {
        test: /\.(otf|ttf)?$/,
        use: [
            {
                loader: 'file-loader',
                options: {
                    name: '[name].[ext]',
                    outputPath: 'fonts/'
                }
            }
        ]
    }
)

config.resolve.modules.push(
    path.resolve(mokoResourcePath)
);