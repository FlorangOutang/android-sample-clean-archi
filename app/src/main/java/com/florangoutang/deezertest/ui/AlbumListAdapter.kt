package com.florangoutang.deezertest.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.florangoutang.deezertest.R
import com.florangoutang.deezertest.ui.AlbumListAdapter.AlbumListCardViewHolder
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListViewModel
import com.florangoutang.deezertest.util.inflateFromParent
import com.florangoutang.deezertest.util.loadUrl
import kotlinx.android.synthetic.main.album_card.view.*

class AlbumListAdapter(private val onAlbumClickedListener: AlbumListFragment.OnAlbumClickedListener,
                       private val currentPositionInList: (Int, Int) -> Unit) : RecyclerView.Adapter<AlbumListCardViewHolder>() {

    var albumList = mutableListOf<AlbumListViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumListCardViewHolder(parent)

    override fun onBindViewHolder(holder: AlbumListCardViewHolder, position: Int) {
        currentPositionInList(position, itemCount)
        holder.bind(albumList[position], onAlbumClickedListener)
    }

    override fun getItemCount() = albumList.size

    class AlbumListCardViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView.inflateFromParent(R.layout.album_card)) {
        fun bind(albumListViewModel: AlbumListViewModel, onAlbumClickedListener: AlbumListFragment.OnAlbumClickedListener) = with(itemView) {
            albumImage.loadUrl(albumListViewModel.coverUrl, R.drawable.album_placeholder)
            albumImage.setOnClickListener { onAlbumClickedListener.onAlbumClicked(albumListViewModel.id)}
            albumTitle.text = albumListViewModel.title
            albumArtist.text = albumListViewModel.artistName
        }
    }
}