package com.example.tictactoe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.game_home_fragment.*
import kotlinx.android.synthetic.main.row.*
import java.util.*

class GameHome : Fragment(),RecyclerViewClickListener {
    val start:Int=1
    val end:Int=9

    private lateinit var viewModel: GameHomeViewModel
   private lateinit var gameAdapter: GameAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameHomeViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            gameadapter.apply {
                val _layoutManager=GridLayoutManager(requireContext(),
                    3)
                 _layoutManager.orientation=LinearLayoutManager.VERTICAL
                layoutManager=_layoutManager
                gameAdapter=GameAdapter(it,this@GameHome)
                adapter=gameAdapter

            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, game: Game) {
        when(game.id){
            1->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            2->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            3->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            4->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            5->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            6->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            7->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            8->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
            9->{
                gamecard.text="X"
                Toast.makeText(requireContext(),"${game.id}",Toast.LENGTH_LONG).show()
                computerMove(game.id)
            }
        }
    }

    private fun computerMove(id:Int) {
        val _random=Random()
        val random=_random.nextInt(end+1-start)+start
        Log.d("random val","${random}")
        if(random!=id){
            gamecard.text="0"
        }else{
            gamecard.text="X"
        }
    }

}