package com.zeus.domain.interactor

import com.zeus.domain.models.Character
import com.zeus.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseUseCase<Unit, Flow<List<Character>>> {

    override suspend fun invoke(parameter: Unit): Flow<List<Character>> {
        return characterRepository.getCharacters()
    }
}
