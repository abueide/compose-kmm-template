import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewModel = TestViewModel()
    
    var body: some View {
        VStack {
            Text("\(viewModel.resourceIdString)")
            Text("\(viewModel.localizedString)")
            Text("\(viewModel.descriptionString)")
            Text("\(viewModel.otherString)")
                .font(Font(viewModel.font))
            Color(viewModel.valueColor)
                .frame(width: 200, height: 200)
            Color(viewModel.themedColor)
                .frame(width: 200, height: 200)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
